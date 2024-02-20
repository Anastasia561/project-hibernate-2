1) film_text and film tables shoul have one-to-one relationship
2) in table film columns original_language_id and original_language are always null, so at least one of them is redundant
3) in table film values from column special_feature should be stored not as a single string, but in a separate table with many-to-many relationship with film table
4) in table film data format of column rating should be changed to make rating values convenient for storing as enum values ('-' should be omitted)
