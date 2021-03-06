package StringStatisticsUtils;

import java.util.*;

public class CharacteristicWords {
	int maxSize;
	public Vector<String> topWords=new Vector<String>();
	public Vector<Double> topScores=new Vector<Double>();

	public CharacteristicWords(int capacity)
	{
		maxSize=capacity;
	}
	public void addElement(String w,double score){
		int i=0;
		while(i<topWords.size()&&score<=topScores.elementAt(i))
			i++;
		topWords.insertElementAt(w,i);
		topScores.insertElementAt(score,i);
		if(topWords.size()>maxSize){
			topScores.removeElementAt(topScores.size()-1);
			topWords.removeElementAt(topWords.size()-1);
		}
	}
	
	public String toString()
	{
		String res="";
		for(int i=0;i<topScores.size();i++)
			res+=(topWords.elementAt(i)+ "\t-\t"+topScores.elementAt(i)+"\n");
		return res;
	}	
}
