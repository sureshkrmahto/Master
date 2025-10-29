package com.iluwatar.masterworker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class ArrayInput extends abstract class {@link Input} and contains data of type int[][].
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class ArrayInput extends Input<int[][]> {

public ArrayInput(int[][] data) {
super(data);
  }

static int[] makeDivisions(int[][] data, int num) {
var initialDivision = data.length / num; //equally dividing
var divisions = new int[num];
Arrays.fill(divisions, initialDivision);
if (initialDivision * num != data.length) {
var extra = data.length - initialDivision * num;
var l = 0;
      //equally dividing extra among all parts
while (extra > 0) {
divisions[l] = divisions[l] + 1;
extra--;
if (l == num - 1) {
l = 0;
        } else {
l++;
        }
      }
    }
return divisions;
  }

@Override
public List<Input<int[][]>> divideData(int num) {
if (this.data == null) {
return null;
    } else {
var divisions = makeDivisions(this.data, num);
var result = new ArrayList<Input<int[][]>>(num);
var rowsDone = 0; //number of rows divided so far
for (var i = 0; i < num; i++) {
var rows = divisions[i];
if (rows != 0) {
var divided = new int[rows][this.data[0].length];
System.arraycopy(this.data, rowsDone, divided, 0, rows);
rowsDone += rows;
var dividedInput = new ArrayInput(divided);
result.add(dividedInput);
        } else {
break; //rest of divisions will also be 0
        }
      }
return result;
    }
  }
}
