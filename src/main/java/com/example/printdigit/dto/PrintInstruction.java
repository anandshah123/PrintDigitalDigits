package com.example.printdigit.dto;

/**
 * Created by Anand on 18-03-2017.
 */
public class PrintInstruction implements Comparable<PrintInstruction> {

    private Instruction instruction;

    private int rowOrder;

    private int columnOrder;

    public PrintInstruction(Instruction instruction, int rowOrder, int columnOrder) {
        this.instruction = instruction;
        this.rowOrder = rowOrder;
        this.columnOrder = columnOrder;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public int getRowOrder() {
        return rowOrder;
    }

    public void setRowOrder(int rowOrder) {
        this.rowOrder = rowOrder;
    }

    public int getColumnOrder() {
        return columnOrder;
    }

    public void setColumnOrder(int columnOrder) {
        this.columnOrder = columnOrder;
    }


    @Override
    public int compareTo(PrintInstruction that) {
        int rowOrderComparision = Integer.compare(this.getRowOrder(), that.getRowOrder());
        return rowOrderComparision == 0 ? Integer.compare(this.getColumnOrder(), that.getColumnOrder()) : rowOrderComparision;
    }
}
