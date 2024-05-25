package Model.SewaAlatGym;
import java.util.List;

public interface InterfaceDAO 
{
   
    public void insert(ModelSewaAlatGym sewa_alat_gym);
    public void update(ModelSewaAlatGym sewa_alat_gym);
    public void delete(String nama_pemilik);
    public List<ModelSewaAlatGym> getAll();
    
}
