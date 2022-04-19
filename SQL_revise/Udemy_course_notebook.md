## Note of SQL for Data Analystics 2021
---

### Lesson 1. Create an account in Mode.com

1. Use a public dataset and SQL editor in mode

2. Use tutorial billboard top 100 dataset

### Lesson 2: Basic SQL fundamentals

Note 1: Every cell in a same columns must have the same datatype. It makes an unique datastructure of database and faster access.

1. Basic query: 
...	SELECT [column names] 
...	FROM [dataset.table_name]

...	WHERE  // -> the query conditions
...	limit 10 // -> similar to pd.Dataframe.head() and be used at very last of the query

...	*Comparison operator*

...	```
...	Select year, year_rank, artist, song_name
...	From tutorial.billboard_top_100_year_end
...	Where artist = 'Adele'
...	```

... 
Note 2: Single quote for String compare operator

2. Logical Operators: 
... AND, OR, NOT: already familiar 
... **LIKE** regex in SQL to search for a specified pattern. `%` - zero, one multiple characters 
... **IN** a list of values 
... **Between** select only rows within a given range
... **IS NULL** select row that contain no data  




