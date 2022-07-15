

package com.dotsafrica.dotsafrica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.dotsafrica.dotsafrica.request.ItemRequest;
import com.dotsafrica.dotsafrica.response.ItemResponse;
import com.dotsafrica.dotsafrica.services.ItemService;


@SpringBootTest
class DotsafricaApplicationTests {

	@Autowired
	private ItemService itemService;

	@Test
	void numberOfItem() {

		// Number page and size testing

		Optional<Integer> pageNumber = Optional.of(0);
		Optional<Integer> numberSize = Optional.of(6);
		Optional<String> sortBy = Optional.of("timestamp");
		assertEquals(4, this.itemService.findPaginated("Khumalo", sortBy, pageNumber, numberSize).size());

		pageNumber = Optional.of(1);
		numberSize = Optional.of(2);
		assertEquals(2, this.itemService.findPaginated("Khumalo", sortBy, pageNumber, numberSize).size());

		pageNumber = Optional.of(1);
		numberSize = Optional.of(3);
		assertEquals(1, this.itemService.findPaginated("Khumalo", sortBy, pageNumber, numberSize).size());

	}

	@Test
	void updateStatus() {

		ItemRequest itemRequest = new ItemRequest();
		Optional<Long> id = Optional.of(4l);
		Optional<String> status = Optional.of("completed");

		itemRequest.setStatus(status);
		itemRequest.setUsername("Khumalo");
		itemRequest.setId(id);
		assertSame("completed", this.itemService.updateStatus(itemRequest));

		// update the completed item must throw an error
		
		IllegalStateException thrwon =  assertThrowsExactly(IllegalStateException.class, () -> {
			Optional<String> s = Optional.of("cancelled");
			itemRequest.setStatus(s);
			this.itemService.updateStatus(itemRequest);		}, "User found");
		assertSame("The item is completed, it connot be revoked", thrwon.getMessage());
	
		// update and created at must should not be the same

		ItemResponse itemResponse = this.itemService.findById("Khumalo", id);
		assertNotSame(itemResponse.getCreate_at(), itemResponse.getUpdated_at());
	}

	@Test
	void getItem() {
		ItemRequest itemRequest = new ItemRequest();
		Optional<Long> id = Optional.of(1l);

		itemRequest.setUsername("Khumalo");
		itemRequest.setId(id);

		// error should be thrown since the id number of the item is not associated with the user "Khumalo"

		IllegalStateException thrwon =  assertThrowsExactly(IllegalStateException.class, () -> {
			this.itemService.findById("Khumalo", id);
		}, "User found");
		assertEquals("Item is not associated with username Khumalo", thrwon.getMessage());

	}

	@Test 
	void deleteItem() {
		Optional<Long> id = Optional.of(4l);

		String deleted = itemService.deleteItem("Khumalo", id);
		assertEquals("Deleted successfull", deleted);

		// detele the same deleted item, error should be thrown

		NoSuchElementException thrwon =  assertThrowsExactly(NoSuchElementException.class, () -> {
			itemService.deleteItem("Khumalo", id);
		}, "User found");
		assertEquals("Item with id  "+ id.get()+" is not in the database", thrwon.getMessage());
	}
}
