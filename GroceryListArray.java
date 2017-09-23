class GroceryListArray implements IGroceryList {
  
  int max = 10;
  GroceryItem items[] = new GroceryItem[max];
  int size = 0;
  
  // CONSTRUCTOR
  GroceryListArray() {
  }
   
   // TEMPLATE:
 /* Fields:
  * 
  * Methods:
  * add(GroceryItem item)      -- boolean
  * remove(String name)        -- boolean
  * markAsBought(String name)  -- boolean
  * display()                  -- void
  * isOnTheList(String name)   -- boolean
  * 
  * 
  * Methods of GroceryItem:
  * toString()       -- String
  * equals(Object o) -- boolean
  * 
  */
  
  
 // GroceryItem -> boolean
 // Returns true if the item is successfully added to the list.
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
  // Given the name of a GroceryItem, returns the corresponding GroceryItem index 
  // from the list. If it is not in the list, returns -1
  int indexOf(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.items[i].equals(new GroceryItem(name, 0))) {
        return i;
      }
    }
    
    return -1;
  }
  
  // Template
  /*   this.item
  *    newItem
  */

 // String -> boolean
 // Returns true,iff an item is successfully removed from the list.
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

  // Templates
  /* this.items
   * 
   */

  // String -> boolean
  // Returns true if an item is successfully bought and mark the box with an "x"
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
  
 // void -> void
 // Displays the information stored on the list.
  public void display() {
    for (int i = 0; i < this.size; i++) {
      System.out.println(items[i]);
    }
  }
}
