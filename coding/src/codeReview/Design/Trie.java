package codeReview.Design;

/**
 * Created by wangdong on 8/14/16.
 */
class TrieNode {
  public char val;
  public boolean isEnd = false;
  TrieNode[] edges = new TrieNode[26];
  // Initialize your data structure here.
  public TrieNode() {
  }
}

public class Trie {
  protected TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    char[] characters = word.toCharArray();
    TrieNode current = root;
    for(char character : characters) {
      int index = character - 'a';
      if(current.edges[index] == null) {
        TrieNode next = new TrieNode();
        next.val = character;
        current.edges[index] = next;
      }

      current = current.edges[index];
    }
    current.isEnd = true;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode current = root;
    char[] characters = word.toCharArray();
    for(char character : characters) {
      if(current.edges[character - 'a'] == null) {
        return false;
      } else {
        current = current.edges[character - 'a'];
      }
    }

    if(current.isEnd == true) {
      return true;
    } else {
      return false;
    }
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    TrieNode current = root;
    char[] characters = prefix.toCharArray();
    for(char character : characters) {
      if(current.edges[character - 'a'] == null) {
        return false;
      } else {
        current = current.edges[character - 'a'];
      }
    }
    return true;
  }

}
