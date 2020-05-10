package com.caner.issuemanagement;

import com.caner.issuemanagement.dto.IssueDto;
import com.caner.issuemanagement.entity.Issue;
import com.caner.issuemanagement.repository.IssueRepository;
import com.caner.issuemanagement.service.impl.IssueServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IssueServiceImplTest {

    @InjectMocks
    private IssueServiceImpl issueService;

    @Mock
    private IssueRepository issueRepository;

    public void testSave() {
        IssueDto issueDto = new IssueDto();
        //date string olmadigindan parse etmek zorunda kaldim
        issueDto.setDate(Timestamp.from(Instant.parse("test- time")));
        issueDto.setDetails("Test- Details");
        issueDto.setDescription("Test-Desc");
        //issueDto.setIssueStatus("statu");

        Issue issueMock = Mockito.mock(Issue.class);

        Mockito.when(issueMock.getId()).thenReturn(1L);
        Mockito.when(issueRepository.save(ArgumentMatchers.any(Issue.class))).thenReturn(issueMock);
        IssueDto result = issueService.save(issueDto);


        assertEquals(result.getDescription(), issueDto.getDescription());
        assertEquals(java.util.Optional.ofNullable(result.getId()), 1L);

        /*      assertEquals	Checks if two primitive types or objects are equal.
                assertTrue	Checks if input condition is true.
                assertFalse	Checks if input condition is false.
                assertNotNull	Checks if an object isn't null.
                 assertNull	Checks if an object is null.
                assertSame	Checks if two object references point to the same object in memory.
                assertNotSame	Checks if two object references do not point to the same object in memory.
                 assertArrayEquals	Checks whether two arrays are equal to each other.
          */
    }
}