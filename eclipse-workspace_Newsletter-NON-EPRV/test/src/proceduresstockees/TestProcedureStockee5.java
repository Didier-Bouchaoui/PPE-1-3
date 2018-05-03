package proceduresstockees;

import java.util.List;

import javax.persistence.*;

public
class
 TestProcedureStockee5 {
public
static
void
 main(String[] 
args
) {
EntityManagerFactory 
emf
 = Persistence.
createEntityManagerFactory
(
"abo"
);
EntityManager 
em
 = 
emf
.createEntityManager();
em
.getTransaction().begin();
StoredProcedureQuery 
procedure
 = 
em
.createStoredProcedureQuery(
"croissancebis"
);
procedure
.registerStoredProcedureParameter(1, 
void
.
class
, ParameterMode.
REF_CURSOR
);
List<Object[]> 
resultats
 = 
procedure
.getResultList()
; 
for
(Object[] 
iter
: 
resultats
)
System.
out
.println(
iter
[0] + 
" "
 + 
iter
[1]);
em
.getTransaction().commit();
em
.close();
emf
.close();
}
}