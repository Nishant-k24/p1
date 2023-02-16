public interface PostReaderInterface {
    // public PostReaderInterface();
    public List<PostInterface> readPostsFromFile(String filename) throws FileNotFoundException;
}