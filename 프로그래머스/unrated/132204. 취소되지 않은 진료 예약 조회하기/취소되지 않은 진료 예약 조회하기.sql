select app.apnt_no, pat.pt_name, app.pt_no, app.mcdp_cd, doc.dr_name, app.apnt_ymd
from doctor doc
join appointment app
on app.mddr_id = doc.dr_id
join  patient pat
on app.pt_no = pat.pt_no
where date_format(app.apnt_ymd, "%Y%m%d") = "20220413" and app.apnt_cncl_yn = "N" and app.mcdp_cd = "CS"
order by app.apnt_ymd