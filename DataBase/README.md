## [MainPage](../index.md)/DataBase

## 阅读索引

Lecture
- [ ] [Lecture 1](./Lecture/Lecture1.md)
- [ ] [Lecture 2](./Lecture/Lecture2.md)
- [ ] [Lecture 3](./Lecture/Lecture3.md)

Labs
- [ ] [Lab 1](./Labs/Lab1/Lab1.md)
- [ ] [Lab 2](./Labs/Lab2/Lab2.md)
- [ ] [Lab 3](./Labs/Lab2/Lab2.md)
- [ ] [Lab 4](./Labs/Lab2/Lab2.md)

```sql
select * from issue where supporter_id = 3;

select * from device where room_id = 3;

select * from sensor where room_id = 2;

select script_id, condition_text from script inner join condition_script cs on script.id = cs.script_id where script_id = 1;

select * from script inner join schedule_script ss on script.id = ss.script_id where script_id = 1;

select * from script inner join list_action_script las on script.id = las.script_id where script_id = 1;

```


<style type="text/css">
    #footer {
        position: relative;
        margin: 0 auto;
        line-height: 20px;
        text-align: center;
        font-size: 12px;
        letter-spacing: 1px;
    }
 
    .content {
        height: 1800px;
        width: 100%;
        text-align: center;
    }
</style>

<div id="footer">
    Powered by
    <a href="https://html5up.net">HTML</a>, 
    <a href="https://markdown.com.cn/">markdown</a>, 
    <a href="https://www.latex-project.org/">LaTeX</a>
    <br>
    Copyright © 2022 | 
    <a href="https://tolia-gh.github.io">Tolia</a>
    <br>
    All Rights Reserved.
    <br>
</div>
