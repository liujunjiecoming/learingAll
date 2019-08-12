import vo.A9MsgVO;
import vo.PageIndexVO;
import vo.PageVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName CommonUtil
 * @Description 工具类
 * @Author JJLiu
 * @Date 19-8-12 上午10:45
 * @Version 1.0
 **/
public class CommonUtil {

    /**
     * string类型转date类型
     *
     * @param str
     * @return
     */
    private static Date strToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * day=1  获取上一个月的第一天
     * day=12 获取上一年同月的第一天
     *
     * @param date
     * @param day
     * @return
     */
    private static String getFirstDay(String date, Integer day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(strToDate(date));
        cal.add(Calendar.MONTH, day);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String first = format.format(cal.getTime());
        return first;
    }

    /**
     * 利用subList方法进行分页
     *
     * @param list        分页数据
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     */
    public static List<A9MsgVO> pageBySubList(List list, int currentPage, int pageSize) {
        int totalCount = list.size();
        int pageCount = 0;
        List<A9MsgVO> subList;
        int m = totalCount % pageSize;
        if (m > 0) {
            pageCount = totalCount / pageSize + 1;
        } else {
            pageCount = totalCount / pageSize;
        }
        if (m == 0) {
            subList = list.subList((currentPage - 1) * pageSize, pageSize * (currentPage));
        } else {
            if (currentPage == pageCount) {
                subList = list.subList((currentPage - 1) * pageSize, totalCount);
            } else {
                subList = list.subList((currentPage - 1) * pageSize, pageSize * (currentPage));
            }
        }
        return subList;
    }

    /**
     * 将集合转化为数组
     *
     * @param a9MsgVOList
     * @return campaignIdArr
     */
    private Long[] listToArray(List<A9MsgVO> a9MsgVOList) {
        List<Long> a9MsgIdList = new ArrayList<>();
        for (A9MsgVO a9MsgVO : a9MsgVOList) {
            //遍历判断CampaignResponse返回信息中是否有错误信息
            a9MsgIdList.add(a9MsgVO.getId());
        }
        return a9MsgIdList.toArray(new Long[a9MsgIdList.size()]);
    }

    /**
     * 获取Mysql中LIMIT分页参数
     *
     * @param page
     * @return
     */
    public PageIndexVO getPageMsg(PageVO page) {
        PageIndexVO pageIndex = new PageIndexVO();

        //分页转成mysql中的 LIMIT
        Integer currentPage = page.getPage();
        Integer pageSize = page.getPageSize();
        int firstIndex = (currentPage - 1) * pageSize;
        int lastIndex = currentPage * pageSize;

        pageIndex.setFirstIndex(firstIndex);
        pageIndex.setSecondIndex(lastIndex);

        return pageIndex;
    }

}
