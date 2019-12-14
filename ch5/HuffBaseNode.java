package ch5;

/** Huffman tree node implementation: Base class */
public interface HuffBaseNode {
  boolean isLeaf(); 
  int weight();
}

