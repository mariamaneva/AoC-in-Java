package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid<T> {
  public final List<List<T>> grid;
  public T defaultValue = (T) ".";

  public Grid(int rows, int columns) {
    this.grid = createGrid(rows, columns, defaultValue);
  }

  public Grid(int rows, int columns, T defaultValue) {
    this.defaultValue = defaultValue;
    this.grid = createGrid(rows, columns, defaultValue);
  }

  private List<List<T>> createGrid(int rows, int columns, T defaultValue) {
    List<List<T>> grid = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      List<T> row = new ArrayList<>();
      for (int j = 0; j < columns; j++) {
        row.add(defaultValue);
      }
      grid.add(row);
    }
    return grid;
  }

  public int getRowsCount() {
    return this.grid.size();
  }

  public int getColumnsCount() {
    return this.grid.get(0).size();
  }

  public List<T> getRow(int y) {
    return this.grid.get(y);
  }

  public List<T> getLastRow() {
    return this.grid.get(this.getRowsCount() - 1);
  }

  public List<T> getLastColumn() {
    return this.getColumn(this.getColumnsCount() - 1);
  }

  public List<T> getColumn(int x) {
    List<T> column = new ArrayList<>();
    for (List<T> row : grid) {
      column.add(row.get(x));
    }
    return column;
  }

  public void addRow(List<T> row) {
    this.grid.add(row);
  }

  public void addColumn(List<T> column) {
    for (int i = 0; i < column.size(); i++) {
      this.grid.get(i).add(column.get(i));
    }
  }

  public void setRow(int y, List<T> row) {
    this.grid.set(y, row);
  }

  public void setColumn(int x, List<T> column) {
    for (int i = 0; i < column.size(); i++) {
      this.grid.get(i).set(x, column.get(i));
    }
  }

  public T getPoint(int x, int y) {
    return this.grid.get(y).get(x);
  }

  /**
   * Set a point in the grid. If the point is out of bounds, the grid will be
   * dynamically scaled to fit the point.
   */
  public void setPoint(int x, int y, T value) {
    while (y >= this.getRowsCount()) {
      this.addRow(new ArrayList<>(Collections.nCopies(this.getColumnsCount(), defaultValue)));
    }
    while (x >= this.getColumnsCount()) {
      this.addColumn(new ArrayList<>(Collections.nCopies(this.getRowsCount(), defaultValue)));
    }
    grid.get(y).set(x, value);
  }

  public void print() {
    for (List<T> row : grid) {
      for (T value : row) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }
}
