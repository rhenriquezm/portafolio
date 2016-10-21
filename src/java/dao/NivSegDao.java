package dao;

import POJO.NivSeg;
import java.util.ArrayList;

public interface NivSegDao {
    
    public ArrayList<NivSeg> getAll();

    public void insert(NivSeg ns);

    public void delete(NivSeg ns);
    
    public void deleteById(int id);

    public void update(NivSeg ns);
   
    public NivSeg getById(int id);
}
