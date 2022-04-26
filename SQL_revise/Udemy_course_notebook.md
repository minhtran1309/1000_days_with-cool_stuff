## Note of SQL for Data Analystics 2021
---

### Lesson 1. Create an account in Mode.com

1. Use a public dataset and SQL editor in mode

2. Use tutorial billboard top 100 dataset

### Lesson 2: Basic SQL fundamentals

Note 1: Every cell in a same columns must have the same datatype. It makes an unique datastructure of database and faster access.

*1. Basic query:* 

	SELECT [column names] 
	FROM [dataset.table_name]

	WHERE  # -> the query conditions

	limit 10 # -> similar to pd.Dataframe.head() and be used at very last of the query

	*Comparison operator*

	```
	Select year, year_rank, artist, song_name
	From tutorial.billboard_top_100_year_end
	Where artist = 'Adele'
	```

 
Note 2: Single quote for String compare operator

*2. Logical Operators:* 

	Allow to query the data with conditions

    AND, OR, NOT: already familiar  

    
    ```
    /* To get Taylor Swift or Adele song in the year of 2011 */
    Select *
    From tutorial.billboard_top_100_year_end
    Where year = 2011
    AND (artist = 'Taylor Swift' 
    OR artist = 'Adele')
    ```

    
    ```
    /* To get Taylor Swift or Adele song in the year of 2011 that is not in the top 20 Billboard list */
    Select *
    From tutorial.billboard_top_100_year_end
    Where year = 2011
    AND (artist = 'Taylor Swift' 
    OR artist = 'Adele')
    AND NOT year_rank > 20
    ```

    The condions can combine together using parentheses

    **LIKE** is a form of regex in SQL to search for a specified pattern. 

        `%` means zero, one multiple characters start or end with pattern

    ```
    /*Get al some where artist contains the word 'Taylor'*/
    Select *
    From tutorial.billboard_top_100_year_end
    Where artist Like 'Taylor%'
    ```



     ```
    /*Get al some where artist contains the word 'Taylor'*/
    Select *
    From tutorial.billboard_top_100_year_end
    Where artist Like '%Taylor%'
    ```

    Note 3: LIKE query is case sensitive, meaning it take upper case and lower case character strictly. 

    To ignore case sensitive use `ILIKE` instead

	```
    /*Get al some where artist contains the word 'Taylor' or 'taylor' */
    Select *
    From tutorial.billboard_top_100_year_end
    Where artist ILike '%taylor%'
    ```

    To match pattern with one idividual character use `_`

    ```
    /*Get al some where artist name starts with t/T and ends  character m/M */
    Select *
    From tutorial.billboard_top_100_year_end
    Where artist ILike 't_m'
    ```

    **IN** given a list of values to query

    ```
    -- Get all songs in Billboard top 3
    Select * From tutoraial.billboard_top_100_year_en
    Where year_rank IN (1, 2, 3)
    ```

  	**IN** can be combine with other to make exclusion list

    ```
    -- Get all songs not belongs to Taylor Swift, Adele, User in 2012
    Select * from tutorial.billboard_top_100_year_end
    Where year = 2012
    And artist NOT IN ('Taylor Swift', 'Adele', 'Usher')
    ```

    **Between** select only rows within a given range

    ```
    Select * from tutorial.billboard_top_100_year_end
    Where year = 2012
    and year_rank => 5 and year_rank <= 10
    ```

    Between can be used to alter two condition and make the query more comprehesive

    ```
    Select * from tutorial.billboard_top_100_year_end
    Where year = 2012
    and year_rank BETWEEN 5 AND 10
    ```

    **IS NULL** select row that contain no data  


    ```
    -- Find missing artist name
    Select * from tutorial.billboard_top_100_year_end
    Where artist is NULL
    ```

    **ORDER BY** sort column data in ascending or descending order

    Note 4: By default `Order By` sort the data by ascending order. Add DESC to the end to sort the descending order


    ```
    Select * From tutorial.billboard_top_100_year_end
    Where artist in ('Adele', 'Taylor Swift', 'Usher')
    Order by artist DESC
    limit 100
    ```

