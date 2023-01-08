package stream;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
/*
 * groupingBy : 스트림을 그룹 지음 
 * partitioningBy : 스트림을 분할 함 
 */
public class collectorGroup {
	public static void main(String[] args) {
		//partitioningBy
		Stream<Unit> star = Stream.of(new Unit(500,"battle",true),new Unit(100,"zealot",true),new Unit(50,"marine",true),
		new Unit(50,"SCV",false));
		Map<Boolean, Optional<Unit>> craft = star.collect(Collectors.partitioningBy(Unit::isCombat,maxBy(comparingInt(Unit::getHp))));
		// 두가지 기준으로 거르기
		star= Stream.of(new Unit(500,"battle",true),new Unit(100,"zealot",true),new Unit(50,"marine",true),
		new Unit(50,"SCV",false),new Unit(300,"Overload",false));
		Map<Boolean, Map<Boolean, List<Unit>>> game = star.collect(partitioningBy(Unit::isCombat,partitioningBy(s->s.hp>=300)));
		System.out.println(game.get(true).get(true));
		System.out.println(game.get(false).get(true));
		System.out.println(game.get(true).get(false));
		System.out.println(game.get(false).get(false));
		//groupingBy 
		Stream<Unit> starcraft = Stream.of(new Unit(500,"battle",true),new Unit(100,"zealot",true),new Unit(50,"marine",true),
				new Unit(50,"SCV",false));
		Map<Boolean,List<Unit>> starMap = starcraft.collect(groupingBy(Unit::isCombat));
		System.out.println(starMap.get(true));
	}
}
