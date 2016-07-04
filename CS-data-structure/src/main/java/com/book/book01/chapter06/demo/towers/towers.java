package com.book.book01.chapter06.demo.towers;

// towers.java
// solves Towers of Hanoi puzzle
// to run this program: C>java TowersApp
////////////////////////////////////////////////////////////////
class TowersApp {
  static int nDisks = 3;

  public static void main(String[] args) {
    doTowers(nDisks, 'A', 'B', 'C');
  }

  //-----------------------------------------------------------
  public static void doTowers(int topN, char src, char inter, char dest) {
    if (topN == 1)
      System.out.println("Disk 1 from " + src + " to " + dest);
    else {
      doTowers(topN - 1, src, dest, inter);   // src to inter

      System.out.println("Disk " + topN + " from " + src + " to " + dest); // move bottom

      doTowers(topN - 1, inter, src, dest);   // inter to dest
    }
  }
//-------------------------------------------------------------
}  // end class TowersApp
////////////////////////////////////////////////////////////////
