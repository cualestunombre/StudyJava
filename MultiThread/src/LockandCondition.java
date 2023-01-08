/*
java.utils.concurrent.locks 패키지
lock의 종류 
ReentrantLock : 일반적인 락 
ReentrantReadWriteLock : 읽기에는 공유적이고 쓰기에는 배타적인 락
즉 읽기락은 동시에 여러개를 걸 수 있고, 쓰기 락은 하나만 걸 수 있음
읽기락이 걸려있으면 쓰기락을 걸 수 없고, 쓰기락이 걸려 있으면 읽기락을 걸 수 없음
StampedLock : ReentrantReadWriteLock에 낙관적 읽기락이 추가된 것
낙관적 읽기락은 쓰기락에 의해 바로 풀리게 되며, 쓰기락이 걸려 있으면 낙관적 읽기락은 쓰기락이 끝날때 까지 기다려야 한다

 */

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

