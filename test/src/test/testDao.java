package test;

import java.util.List;

public interface testDao {
	void register(testDto testDto);
	testDto searchById(String trnscSerialNumber);
	List<testDto> searchAll();
}
