package com.sddevops.junit_maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class SongCollectionTest {

	private SongCollection sc;
	private ArrayList<Song> songs = new ArrayList<>();

	private Song s1;
	private Song s2;
	private Song s3;
	private Song s4;
	private final int SONG_COLLECTION_SIZE = 4;
	
	private String artiste;

	private int capacity;

	@BeforeEach
	void setUp() throws Exception {
		// [Arrange]
		sc = new SongCollection();
		s1 = new Song("0001", "good 4 u", "Olivia Rodrigo", 3.59);
		s2 = new Song("0002", "Peaches", "Justin Bieber", 3.18);
		s3 = new Song("0003", "MONTERO", "Lil Nas X", 2.3);
		s4 = new Song("0004", "bad guy", "Billie Eilish", 3.14);

		sc.addSong(s1);
		sc.addSong(s2);
		sc.addSong(s3);
		sc.addSong(s4);

		capacity = 20;

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSongs() {

	}
	
	@Test
	void testGetSetArtiste() {
		
		s1.setArtiste("test");
		
		assertEquals("test", s1.getArtiste());
		
	}
	
	@Test
	void testGetSetSongLength() {
		
		s1.setSongLength(0.00);
		
		assertEquals(0.00, s1.getSongLength());
		
	}

	@Test
	void testAddSong() {
		// fail("Not yet implemented");
		List<Song> testSc = sc.getSongs();
		// [Assert] that Song Collection is equals to song collection size 4\

		assertEquals(testSc.size(), SONG_COLLECTION_SIZE);

		assertNotEquals(capacity, testSc.size());
		 
		// [Act]
		sc.addSong(s1);
		// Assert that Song Collection is equals to song collection size 4 + 1
		assertEquals(sc.getSongs().size(), SONG_COLLECTION_SIZE + 1);
	}
	
	@Test
	void testAddSongHitLimit() {
		// fail("Not yet implemented");
		capacity = 4;
		// [Assert] that Song Collection is equals to song collection size 4\

		assertEquals(capacity, SONG_COLLECTION_SIZE);

	}

	@Test
	void testSortSongsByTitle() {
		// Arrange
		List<Song> testSc = sc.getSongs();
		System.out.println(testSc);
		// Act
		Collections.sort(testSc, Song.titleComparator);
		System.out.println(testSc);
		// Assert
		assertEquals(sc.sortSongsByTitle(), testSc);

	}

	@Test
	void testSortSongsBySongLength() {
		// Arrange
		List<Song> testSc = sc.getSongs();
		System.out.println(testSc);
		// Act
		Collections.sort(testSc, Song.songLengthComparator);
		System.out.println(testSc);
		// Assert
		assertEquals(sc.sortSongsBySongLength(), testSc);
	}

	@Test
	void testFindSongsById() {
		
		//Act
		sc.findSongsById(s1.getId());
		
		//Assert
		assertNotNull(sc.findSongsById(s1.getId()));
	}
	
	@Test
	void testFindSongsByIdNullOutput() {
		//Arrange
		Song s5 = new Song(null, null, null, 0.00);
		s5.setId("0005");
		//Act
		sc.findSongsById(s5.getId());
		
		//Assert
		assertNull(sc.findSongsById(s5.getId()));
	}

	@Test
	void testFindSongByTitle() {
		
		//Act
		sc.findSongByTitle(s1.getTitle());
		
		//Assert
		assertNotNull(sc.findSongByTitle(s1.getTitle()));
	}
	
	@Test
	void testFindSongByTitleNullOutput() {
		//Arrange
		Song s5 = new Song(null, null, null, 0.00);
		s5.setTitle("unit test");
		
		//Act
		sc.findSongByTitle(s5.getTitle());
		
		//Assert
		assertNull(sc.findSongByTitle(s5.getTitle()));
	}

}
