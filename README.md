# java-sprint2-hw
Second sprint homework

<h2><strong>Автоматизация бухгалтерии</strong></h2>
<h4>Консольный интерфейс</h4>
<div class="paragraph">Консольный интерфейс по работе с программной позволяет оператору произвести одно из пяти действий по выбору:</div>
<ol start="1">
<li>Считать все месячные отчёты</li>
<li>Считать годовой отчёт</li>
<li>Сверить отчёты</li>
<li>Вывести информацию о всех месячных отчётах</li>
<li>Вывести информацию о годовом отчёте</li>
</ol>
<div class="paragraph">
<h4></h4>
<h4>Считывание файлов</h4>
<div class="paragraph">Программа позволяет считывать месячные и годовые отчёты. При выборе оператором действия &laquo;считать месячный отчёт&raquo; происходит считывание трёх файлов:</div>
<ul>
<li><code class="code-inline code-inline_theme_light">m.202101.csv</code></li>
<li><code class="code-inline code-inline_theme_light">m.202102.csv</code></li>
<li><code class="code-inline code-inline_theme_light">m.202103.csv</code></li>
</ul>
<div class="paragraph">При выборе действия &laquo;считать годовой отчёт&raquo; происходит считывание из одного файла:</div>
<ul>
<li><code class="code-inline code-inline_theme_light">y.2021.csv</code></li>
</ul>
<h4>Сверка данных</h4>
<div class="paragraph">Сверка данных &mdash; это проверка, что данные в двух и более разных источниках не противоречат друг другу. В данном случае при сверке данных информация по месяцу в годовом отчёте не противоречит информации в месячном отчёте.</div>
<div class="paragraph">При вызове сверки данных программа:</div>
<ol start="1">
<li>Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев.</li>
<li>Сверять полученные суммы с суммой доходов и расходов в отчёте по году.</li>
</ol>
<div class="paragraph">Если обнаружена ошибка, программа выводит месяц, в котором обнаружено несоответствие.</div>
<div class="paragraph">Если ошибок не обнаружено, выводиться только информация об успешном завершении операции.</div>
<div class="paragraph"></div>
<div class="paragraph">
<h4>Информация о всех месячных отчётах</h4>
<div class="paragraph">При вызове этой функции программа выводит следующие данные:</div>
<ul>
<li>Название месяца;</li>
<li>Самый прибыльный товар (название товара и сумму);</li>
<li>Самую большую трату (название товара и сумму).</li>
</ul>
<div class="paragraph">Эта информация выводиться по каждому из месяцев.</div>
<div class="paragraph"></div>
<div class="paragraph">
<h4>Информация о годовом отчёте</h4>
<div class="paragraph">При вызове этой функции программа выводит следующие данные:</div>
<ul>
<li>Рассматриваемый год;</li>
<li>Прибыль по каждому месяцу. Прибыль &mdash; это разность доходов и расходов;</li>
<li>Средний расход за все месяцы в году;</li>
<li>Средний доход за все месяцы в году.</li>
</ul>
<p></p>
</div>
</div>
</div>