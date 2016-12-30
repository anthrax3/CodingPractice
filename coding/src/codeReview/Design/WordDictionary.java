package codeReview.Design;

/**
 * Created by wangdong on 8/14/16.
 */

class WildMatchTrie extends Trie {
  // Returns if the word is in the trie.
  public boolean search(TrieNode start, String word) {
    if(start == null) {
      return false;
    }
    if(word.isEmpty()) {
      if (start.isEnd) {
        return true;
      } else {
        return false;
      }
    }

    TrieNode current = start;
    char currentChar = word.charAt(0);

    if(currentChar != '.') {
      return search(current.edges[currentChar - 'a'], word.substring(1));
    } else {
      for(TrieNode next : current.edges) {
        if(false == search(next, word.substring(1))) {
          continue;
        } else {
          return true;
        }
      }
    }

    return false;
  }
}
public class WordDictionary {
  WildMatchTrie dic = new WildMatchTrie();

  // Adds a word into the data structure.
  public void addWord(String word) {
    dic.insert(word);
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return dic.search(dic.root, word);
  }
}
