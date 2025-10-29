package com.hexagonal.database;

import com.hexagonal.domain.LotteryNumbers;
import com.hexagonal.domain.LotteryTicket;
import com.hexagonal.domain.LotteryTicketId;
import com.hexagonal.domain.PlayerDetails;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.bson.Document;

/**
 * Mongo lottery ticket database.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class MongoTicketRepository implements LotteryTicketRepository {

private static final String DEFAULT_DB = "lotteryDB";
private static final String DEFAULT_TICKETS_COLLECTION = "lotteryTickets";
private static final String DEFAULT_COUNTERS_COLLECTION = "counters";
private static final String TICKET_ID = "ticketId";

private MongoClient mongoClient;
private MongoDatabase database;
private MongoCollection<Document> ticketsCollection;
private MongoCollection<Document> countersCollection;

  /**
   * Constructor.
 *  @author Suresh Mahto
   */
public MongoTicketRepository() {
connect();
  }

  /**
   * Constructor accepting parameters.
 *  @author Suresh Mahto
   */
public MongoTicketRepository(String dbName, String ticketsCollectionName,
String countersCollectionName) {
connect(dbName, ticketsCollectionName, countersCollectionName);
  }

  /**
   * Connect to database with default parameters.
 *  @author Suresh Mahto
   */
public void connect() {
connect(DEFAULT_DB, DEFAULT_TICKETS_COLLECTION, DEFAULT_COUNTERS_COLLECTION);
  }

  /**
   * Connect to database with given parameters.
 *  @author Suresh Mahto
   */
public void connect(String dbName, String ticketsCollectionName,
String countersCollectionName) {
if (mongoClient != null) {
mongoClient.close();
    }
mongoClient = new MongoClient(System.getProperty("mongo-host"),
Integer.parseInt(System.getProperty("mongo-port")));
database = mongoClient.getDatabase(dbName);
ticketsCollection = database.getCollection(ticketsCollectionName);
countersCollection = database.getCollection(countersCollectionName);
if (countersCollection.count() <= 0) {
initCounters();
    }
  }

private void initCounters() {
var doc = new Document("_id", TICKET_ID).append("seq", 1);
countersCollection.insertOne(doc);
  }

  /**
   * Get next ticket id.
   *
   * @return next ticket id
 *  @author Suresh Mahto
   */
public int getNextId() {
var find = new Document("_id", TICKET_ID);
var increase = new Document("seq", 1);
var update = new Document("$inc", increase);
var result = countersCollection.findOneAndUpdate(find, update);
return result.getInteger("seq");
  }

  /**
   * Get tickets collection.
   *
   * @return tickets collection
 *  @author Suresh Mahto
   */
public MongoCollection<Document> getTicketsCollection() {
return ticketsCollection;
  }

  /**
   * Get counters collection.
   *
   * @return counters collection
 *  @author Suresh Mahto
   */
public MongoCollection<Document> getCountersCollection() {
return countersCollection;
  }

@Override
public Optional<LotteryTicket> findById(LotteryTicketId id) {
return ticketsCollection
        .find(new Document(TICKET_ID, id.getId()))
        .limit(1)
        .into(new ArrayList<>())
        .stream()
        .findFirst()
        .map(this::docToTicket);
  }

@Override
public Optional<LotteryTicketId> save(LotteryTicket ticket) {
var ticketId = getNextId();
var doc = new Document(TICKET_ID, ticketId);
doc.put("email", ticket.getPlayerDetails().getEmail());
doc.put("bank", ticket.getPlayerDetails().getBankAccount());
doc.put("phone", ticket.getPlayerDetails().getPhoneNumber());
doc.put("numbers", ticket.getNumbers().getNumbersAsString());
ticketsCollection.insertOne(doc);
return Optional.of(new LotteryTicketId(ticketId));
  }

@Override
public Map<LotteryTicketId, LotteryTicket> findAll() {
return ticketsCollection
        .find(new Document())
        .into(new ArrayList<>())
        .stream()
        .map(this::docToTicket)
        .collect(Collectors.toMap(LotteryTicket::getId, Function.identity()));
  }

@Override
public void deleteAll() {
ticketsCollection.deleteMany(new Document());
  }

private LotteryTicket docToTicket(Document doc) {
var playerDetails = new PlayerDetails(doc.getString("email"), doc.getString("bank"),
doc.getString("phone"));
var numbers = Arrays.stream(doc.getString("numbers").split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
var lotteryNumbers = LotteryNumbers.create(numbers);
var ticketId = new LotteryTicketId(doc.getInteger(TICKET_ID));
return new LotteryTicket(ticketId, playerDetails, lotteryNumbers);
  }
}
