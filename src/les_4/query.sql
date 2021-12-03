
SELECT  f.*, t.SrartTime, DATE_ADD(t.SrartTime, INTERVAL  dur.DurationMinutes  MINUTE)
 FROM les_i.tscedule as sch
inner join tfilms as f on f.pk = sch.film
inner join tsrarttimes as t on t.pk = sch.Time
inner join les_i.tfilmduration as dur on dur.pk = f.pkDuration
WHERE DATE_ADD(t.SrartTime, INTERVAL  dur.DurationMinutes  MINUTE) > SOME (
	SELECT  t2.SrartTime
	FROM les_i.tscedule as sch2
	inner join tsrarttimes as t2 on t2.pk = sch2.Time
	WHERE t2.SrartTime > t.SrartTime
)
order by t.SrartTime



select t.SrartTime,  Sum(tp.Price)
FROM ttickets as tk
inner join tfilms as f on f.pk = tk.pkFilm
inner join tsrarttimes as t on t.pk = tk.pkFilmTime
inner join tticketprices as tp on tp.pk = tk.pkPrce
group by t.SrartTime