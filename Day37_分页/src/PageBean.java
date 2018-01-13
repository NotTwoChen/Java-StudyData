import java.util.List;

public class PageBean {
    private List<Book> bookList;//分页后的book对象集合
    private int pageCode;//页码
    private int totalData;//book对象集合的长度
    private int pageSize = 10;//分页后的book对象集合的长度

    public int getTotalData() {
        return totalData;
    }

    // 多条件组合查询时的参数
    private String params;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getTotalPages() {
        return totalData % 10 > 0 ? totalData / 10 + 1 : totalData / 10;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "bookList=" + bookList +
                ", pageCode=" + pageCode +
                ", totalPages=" + getTotalPages() +
                ", totalData=" + totalData +
                ", pageSize=" + pageSize +
                ", params='" + params + '\'' +
                '}';
    }

    public PageBean() {
    }

    public PageBean(List<Book> bookList, int pageCode, int totalData, int pageSize, String params) {

        this.bookList = bookList;
        this.pageCode = pageCode;
        this.totalData = totalData;
        this.pageSize = pageSize;
        this.params = params;
    }
}
