package Userzuo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
将ResultSet转换成List的接口
*/

public interface Mapper<E>{
 	abstract public List<E> map(ResultSet rs) throws SQLException;
}
