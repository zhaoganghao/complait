package cn.e21.hbjyhf.web.utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.e21.hbjyhf.model.Data;

public class SortTest {

	// list:传入的list，compareField：指定排序字段，isReverse：是否翻转list，true从大到小，false从小到大
	public static void listSort(List<Data> list,
			final String compareField, Boolean isReverse) {
		Collections.sort(list, new Comparator<Data>() {
			public int compare(Data arg0, Data arg1) {
				int i = 0;

				if (compareField.equals("number")) {
					i = arg0.getNumber().compareTo(arg1.getNumber());
				} else if (compareField.equals("replyednumber")) {
					i = arg0.getNoreplynumber().compareTo(
							arg1.getNoreplynumber());
				} else if (compareField.equals("noreplynumber")) {
					i = arg0.getNoreplynumber().compareTo(
							arg1.getNoreplynumber());
				} else if (compareField.equals("overduenumber")) {
					i = arg0.getOverduenumber().compareTo(
							arg1.getOverduenumber());
				} else if (compareField.equals("checknumber")) {
					i = arg0.getChecknumber().compareTo(arg1.getChecknumber());
				} else if (compareField.equals("checkpercent")) {
					i = arg0.getCheckpercent()
							.compareTo(arg1.getCheckpercent());
				} else if(compareField.equals("startdate")) {
					i = arg0.getStartdate().compareTo(arg1.getStartdate());
				}else {
					i = arg0.getId().compareTo(arg1.getId());
				} 
				return i;
			}
		});
		// 是否倒叙输出？true:倒叙，即从大到小；false：默认，从小到大
		if (isReverse) {
			Collections.reverse(list);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Data d1 = new Data();
		d1.setId(4);
		d1.setNumber(11);
		Data d2 = new Data();
		d2.setId(2);
		d2.setNumber(22);
		Data d3 = new Data();
		d3.setId(3);
		d3.setNumber(33);
		ArrayList<Data> list =  new ArrayList<Data>();
		list.add(d2);
		list.add(d1);
		list.add(d3);

		// 按照指定的字段排序
		String compareField = "number";
		//按照从小到大
		Boolean isReverse = true;
		listSort(list, compareField, isReverse);

		// test 通过
		for (Data d : list) {
			// System.out.println(d.getId());
			System.out.println(d.getNumber());
		}
	}
}
