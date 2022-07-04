package com.example.assignment;

import com.example.assignment.entity.BlinkList;
import com.example.assignment.repository.BlinkListRepository;
import com.example.assignment.service.BlinkListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class Restdemo1ApplicationTests {

	@Autowired
	public BlinkListService blinkListService;

	@MockBean
	public BlinkListRepository blinkListRepository;



	@Test
	 void toTestFindAll()
	{
		when(blinkListRepository.findAll()).thenReturn(Stream.of(new BlinkList(1,"SteveJobs","WalterIsaacson","Entrepreneurship","currentlyReading","images.updateimage.com")).collect(toList()));
		assertEquals(1,blinkListService.findAll().size());
	}

	@Test
	void toTestSave()
	{
		BlinkList blinkList = new BlinkList(1,"SteveJobs","WalterIsaacson","Entrepreneurship","currentlyReading","images.updateimage.com");
		blinkListService.save(blinkList);
		verify(blinkListRepository).save(blinkList);
	}
	@Test
	void toTestDeleteById()
	{
		int id = 10;
		blinkListService.deleteById(id);
		verify(blinkListRepository).deleteById(id);
	}

}
