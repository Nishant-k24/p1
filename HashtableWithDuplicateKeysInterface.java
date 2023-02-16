public interface HashtableWithDuplicateKeysInterface<KeyType, ValueType> extends MapADT<KeyType,java.util.List<ValueType>> {
    //public HashtableWithDuplicateKeysInterface(int capacity);
    //public HashtableWithDuplicateKeysInterface();
    public void putOne(KeyType key, ValueType value);
    public void removeOne(KeyType key, ValueType value);
    public int getNumberOfValues();
}
