package com.example.russiandiamond;

import java.util.ArrayList;
import java.util.List;
/**
 * ����ڴ����Ҫ����ѭ��ʹ����Ϸ�д����ķ���
 * ���������������᲻�ϵ��������ձ������ķ���
 * @author tsingyi
 *
 * @param <T>
 */
class Pool<T> {
      private List<T> allocated;
      private List<T> unallocated;
      public void push(T object){
    	  allocated.add(object);
      }
      public Pool(){
    	  allocated = new ArrayList<T>();
    	  unallocated = new ArrayList<T>();
      }
      public T getInstance(){
           T object = unallocated.remove(unallocated.size() - 1);
           allocated.add(object);
          return object;
      }
      public void Free(T object){
    	  unallocated.add(object);
      }
}
