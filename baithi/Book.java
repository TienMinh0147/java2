
package baithi;

import java.io.Serializable;

public class Book implements Serializable{
    String ms;
    String ts;
    String tl;
    int sl;

    public Book(String ms, String ts, String tl, int sl) {
        this.ms = ms;
        this.ts = ts;
        this.tl = tl;
        this.sl = sl;
    }
    
    public Book(){       
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }  
}
