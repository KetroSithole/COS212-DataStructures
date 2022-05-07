/**
 * A simplistic database table class. Uses the record class to store row data
 * and the index class to
 * maintain indexes for specific columns.
 * Class also implements basic SQL methods. Uses the error class for common
 * error messages.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Table {

	private String name;
	private String[] columns;
	private Record[] records;
	private Index[] indexes;
	private int rowId;
	private int recordCount;
	private int indexCount;
	private int indexOrder; // the BPlusTree order to make all of the indices for this table

	public Table(String name, String[] columns, int indexOrder) {
		this.rowId = 1; // start index in records array
		this.recordCount = 0;
		this.indexCount = 0;
		this.name = name; // name of the table
		this.columns = columns;
		this.indexOrder = indexOrder;
		this.records = new Record[1000]; // initial size of table. Assume this will not be exceeded
		this.indexes = new Index[10]; // initial number of indexes. Assume this will not be exceeded
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRecordCount() {
		return this.recordCount;
	}

	public int getIndexCount() {
		return this.indexCount;
	}

	// you can ignore this function
	public String debug() {
		String result = "";
		if (indexCount > 0) {
			for (int i = 0; i < indexCount; i++) {
				Index idx = indexes[i];
				result += idx.getColumnName() + "\n";
				result = result + idx.getIndex().getDebugString();
				if ((i + 1) < indexCount)
					result = result + " ";
			}
		} else {
			result = "No Indexes!";
		}
		return result;
	}

	////// You may not change any code above this line //////

	////// Implement the functions below this line //////

	/**
	 * Insert the given "rec" in this table. Every record needs to have a unique row id which increments after each insert. RowIDs are never reused (unless the table is reset).
	 * Should indexes be present, they need to be updated.
	 */
	// SQL: insert into table values (rec)
	public void insert(Record rec) {

	}



	/**
	   Print all the records in this table where the given "column" matches "value".
	   Should call the getValues method of the record class. Needs to use the index for "column" and call the
	   search method of the used B+ tree. If no index exists for "column", conventional record iteration and
	   search should be used.
	   If the table is empty, print Err1.
	   else if the column does not exist print Err5.
	   else if no record matches, print error Err4.
	 */
	// SQL: select * from table where column = value
	public void selectWhere(String column, Object value) {
	
	}

	/**
	 * Print all the records in this table ordered by the given "ocolumn" in ascending order (only if there is an index for "ocolumn").
	 * Should call the getValues method of the record class. Needs to use the index for ocolumn
	 * and call the values method of the used B+ tree. Remember to print all the records based on the order given in the index.
	 * If the table is empty, print error message 1. 
	 * else if no indexes are present at all, print error message 2.
	 * else if there is no index available for "ocolumn", print error message 3.
	 */
	// SQL: select * from table order by ocolumn
	public void selectOrderBy(String ocolumn) {
		
	}

	/**
	 * Print all the records in this table. Should call the getValues method of the
	 * record class. If the table is empty print error message 1.
	 */
	// SQL: select * from table
	public void selectAll() {

	}
	
	/**
	 * Delete all the records in this table. recordCount and row id should be reset. Should also clear all indexes.
	 */
	// SQL: delete from table
	public void deleteAll() {

	}
	
	/**
	 * Delete all the records in this table where the given "column" matches "value".
	 * Needs to use the index for "column" and call the search method of the used B+ tree in order to find the rowIDs and set the corresponding records to null.
	 * If no index exists for "column", conventional record iteration and search should be used.
	 * Deleted rows remain empty and the records array should NOT be compacted. recordCount however should be updated.
	 * Should indexes be present, they need to be updated.
	 * For the index named "column" (if it exists), the delete function of the index can simply be used because ALL of the ValueNodes need to be deleted for the key named "value".
	 * However, the corresponding RowIDs need to be removed from ALL of the indexes where they occur, not just the "column" index.
	 * This may involve manually searching through the corresponding ValueNode linked lists for the rowIDs to be deleted.
	 * You may add a helper function(s) in your BPTree class to achieve this additional task. 
	 * If an entire ValueNode list is deleted, then the corresponding key is also deleted using the normal delete function.
	 * If the table is empty print Err1, 
	 * else if the column name is not found print Err5
	 * else if no records are found that equal the value print Err4
	 */
	// SQL: delete from table where column equals value
	public void deleteWhere(String column, Object value) {

	}

	/**
	 * Create an index called "name" using the record values from "column" as keys
	 * and the row id as value. Insert values into the B+ tree in the order of the records in the table.
	 * The created B+ tree must match the data type of "column". 
	 * Return true if successful and false if column does not exist.
	 */
	public boolean createIndex(String name, String column) {

	}

	/**
	 * Print all the keys in the index "name". Should call the print method of the
	 * used B+ tree. If an index with name "name" doesn't exist, then do nothing.
	 */
	public void printIndex(String name) {

	}

}