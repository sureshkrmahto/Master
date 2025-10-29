package com.databus;

import java.util.function.Consumer;

/**
 * Members receive events from the Data-Bus.
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public interface Member extends Consumer<DataType> {

void accept(DataType event);
}
