package pglp5_2.pglp5_2;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;




public class PerDao extends BaseDao implements PersonnelDao{

	public void add(Personnel per) {
		this.executeSql("insert into Personnel values(null,?,?)", per.getNom(),per.getPrenom());

		
	}

	public void update(Personnel per) {
		this.executeSql("update Personnel set Nom=?,Prenom=? where isbn=?", per.getNom(),per.getPrenom(),per.getIsbn());

		
	}

	public void delete(int isbn) {
		this.executeSql("delete from Personnel where isbn=?", isbn);
		
	}

	public List<Personnel> getAll() {
		return this.convert(this.executeQuery("select isbn,nom,prenom from Personnel"));
		
	}

	private List<Personnel> convert(List<Map<String,Object>> list){
		List<Personnel> bList=new ArrayList<Personnel>();
		for(Map<String,Object> map:list) {
			Personnel p=new Personnel();
			p.setIsbn((Integer)map.get("isbn"));
			p.setNom(map.get("Nom").toString());
		
			bList.add(p);
		}
		return bList;
	}


}