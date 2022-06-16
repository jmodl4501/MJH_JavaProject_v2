package web01.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.tomcat.jni.Buffer;

import com.sun.jdi.Value;

public class StringUtil {

	public static String mapKeyValue(Map<String, Object> applyParam)
	{
		StringBuffer result = new StringBuffer(); //String Buffer는 클래스 내부적으로 독립적인 공간을 가짐. 언제나 16개의 문자를 담을 수 있도록 만들어짐. String의 경우 결합할수록 이런 크기가 늘어나는데, StringBuffer를 이용하면 공간낭비가 없어짐. 즉 공간낭비를 줄이기 위해!
		result.append("Map key:Value...\n");
		
		Set<String> debugKeys	= applyParam.keySet();	//Set은 List랑 비슷한 개념인데, 중복값 허용안함.(그렇다고 에러를 떨어트리지도 않음. 특정 순서가 없다. 이런 특징이 있다는 것만!) 그래서 이걸 가져가려면 인덱스나 배열이 아니니 Iterator로만 가져와야 함. 순서가 없긴 하지만 대부분 넣은 순서대로 나옴 ㅋ [https://wakestand.tistory.com/111]
		Iterator<String> it		= debugKeys.iterator(); //iterator: 반복자
		while (it.hasNext()) { /* Iterator에 뭐가 남아있으면 털때까지 반복 */
			String k	= (String) it.next();
			result.append(k+":"+applyParam.get(k)+"\n");
		} // it.hasNext END
		
		return result.toString();
	}

}
