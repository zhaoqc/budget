package utils;

import java.util.Collection;

public class CollectionUtils {
	
	public static boolean isEmpty(Collection<? extends Object> collection){
		boolean result = false;
		if(collection==null||collection.isEmpty()){
			result = true;
		}
		return result;
	}
	
	public static boolean isNotEmpty(Collection<? extends Object> collection){
		return !isEmpty(collection);
	}
}
