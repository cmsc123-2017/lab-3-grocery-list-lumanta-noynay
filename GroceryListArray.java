class GroceryListArray implements IGroceryList {
  
  int max = 10;
  GroceryItem items[] = new GroceryItem[max];
  int size = 0;
  
  GroceryListArray() {}
    
  // GroceryItem -> boolean
  // Accepts this item to the array list
  // Returns true if this item is successfully added, false otherwise
  public boolean add(GroceryItem item) {
    if (size == max) {
      int i = 0;
      max += 10;
      GroceryItem newList[] = new GroceryItem[max];
      
      for(i = 0; i < items.length; i++){
        newList[i] = items[i];
      }
      
      newList[i + 1] = item;
      items = newList;
    }
    int i = indexOf(item.name);
    if (i > -1){
      items[i].addQuantity(item.quantity);
    }
    else{
      items[this.size] = item;
      this.size++;
    }
    return true;
  }
     
  // TEMPLATE
  /*  Fields:
   *    this.max
   *    this.items   --GroceryItem[]
   *    this.size
   * 
   *  Methods:
   *    this.add
   *    this.indexOf
   *    this.remove
   *    this.markAsBought
   *    this.display
   * 
   *  Methods on this.items[i]:
   *    this.items[i].addQuantity()
   *    this.items[i].equals()
   *    this.items[i].toString()
   */
  
   
  // String -> int
  // Given the name of a GroceryItem, returns the
  // corresponding GroceryItem index from the list. If it is not in the list,
  //  returns -1
  int indexOf(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.items[i].equals(new GroceryItem(name, 0))) {
        return i;
      }
    }
    
    return -1;
  }
  
  // String -> boolean
  // Given the name of a GroceryItem, determines if the GroceryItem is successfully removed from
  // the GroceryListArray, returns false if not.
  public boolean remove(String name) {
    int i = 0;
    boolean isOnList = false;
    for (i = 0; i < this.size; i++){
      if (items[i].name.equals(name)){
        isOnList = true;
        items[i] = items[size - 1];
        break;
      }
    }

    max--;
    this.size--;
    return isOnList;
  }


  // String -> boolean
  // Given the name of a GroceryItem, returns true if the GorceryItme is sucessfully
  // makredAsBought, returs false if not
  public boolean markAsBought(String name) {
    int i = indexOf(name);
    if (i >= 0){
      items[i].isBought = true;
      return true;
    }
    else{
      return false;
    }
  }
  
  // ->
  // Displays list of items
  public void display() {
    for (int i = 0; i < this.size; i++) {
      System.out.println(items[i]);
    }
  }
}
