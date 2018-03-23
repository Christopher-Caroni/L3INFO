Definition faux := forall (P : Prop), P.
Definition non (A : Prop) := forall (P : Prop), ((A -> faux) -> P) -> P.
Definition et (A B : Prop) := forall (P : Prop), (A -> B -> P) -> P.
Definition ou (A B : Prop) := forall (P : Prop), ((A -> P) -> (B -> P) -> P).
Definition existe (A : Type) (P : A -> Prop) := forall (Q : Prop), (forall a, P a -> Q) -> Q.
Definition egal (A : Type) (a a' : A) := forall (P : A -> Prop), P a -> P a'.

Lemma bottom_e (A : Prop) : faux -> A.
Proof.
intro a.
apply a.
Qed.

Lemma non_intro (A : Prop) : (A -> faux) -> non A.
Proof.
intros a b c.
apply c.
exact a.
Qed.

Lemma non_elim (A : Prop) : A -> non A -> faux.
Proof.
intros a b.
apply b.
intro c.
apply c.
exact a.
Qed.

Lemma et_intro (A B : Prop) : A -> B -> et A B.
Proof.
intros a b c d.
apply d.
exact a.
exact b.
Qed.

Lemma et_elim_g (A B : Prop) : et A B -> A.
Proof.
intros et_a_b.
apply et_a_b.
intros a b.
exact a.
Qed.

Lemma et_elim_d (A B : Prop) : et A B -> B.
Proof.
intros et_a_b.
apply et_a_b.
intros a b.
exact b.
Qed.

Lemma ou_intro_g (A B : Prop) : A -> ou A B.
Proof.
intros a p Ap Bp.
apply Ap.
exact a.
Qed.

Lemma ou_intro_d (A B : Prop) : B -> ou A B.
Proof.
intros b p Ap Bp.
apply Bp.
exact b.
Qed.

Lemma ou_elim (A B C : Prop) : ou A B -> (A -> C) -> (B -> C) -> C.
Proof.
intros ou_a_b ac bc.
apply ou_a_b.
exact ac.
exact bc.
Qed.


Lemma existe_intro (A : Type) (P : A -> Prop) : forall x : A, P x -> existe A P.
Proof.
 intro pt.
 intro a.
 intro b.
 intro c.
 apply (c pt).
 exact a.
Qed.


Lemma existe_elim (A : Type) (P : A -> Prop) (Q : Prop) : existe A P -> (forall x : A, P x -> Q) -> Q.
Proof.
intros a b.
apply a.
apply b.
Qed.

Lemma faux_false : faux <-> False.
Proof.
split.
intros a.
apply a.
intros a.
destruct a.
Qed.

Lemma non_not (A : Prop) : non A <-> ~A.
Proof.
split.
-intros a b.
 apply a.
 intro c.
 apply c.
 exact b.
-intros a b c.
 apply c.
 intro d.
 destruct a.
 exact d. 
Qed.

Lemma et_and (A B : Prop) : et A B <-> A /\ B.
Proof.
split.
-intros a.
 apply a.
 split.
 exact H.
 exact H0.
-intros a b c.
 destruct a.
 apply c.
 exact H.
 exact H0.
Qed.


Lemma ou_or (A B : Prop) : ou A B <-> A \/ B.
Proof.
 split.
 - intro t.
   apply t.
   intro a.
   left.
   exact a.
   intro b.
   right.
   exact b.
 - intros t a b.
   destruct t.
   + intro c.
     apply b.
     exact H.
   + intro c.
     apply (c H).
Qed.



Lemma existe_exists (A : Type) (P : A -> Prop) : existe A P <-> exists a, P a.
Proof.
split.
- intro a.
  apply a.
  intros b c.
  exists b.
  exact c.
- intros a b c.
  destruct a as [d e].
  apply (c d).
  exact e.
Qed.


Lemma egal_eq (A : Type) (a a' : A) : egal _ a a' <-> a = a'.
Proof.
split.
-intros b.
 apply b.
 reflexivity.
-intros c d e.
 destruct c.
 exact e. 
Qed.

