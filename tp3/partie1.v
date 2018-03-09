Lemma exemple (A : Prop) :  A -> A.
Proof.
intro a.
exact a.
Show Proof.
Qed.

Lemma hilbertS (A B C : Prop) :  (A -> B -> C) -> (A -> B) -> A -> C.
Proof.
intros abc ab a.
apply abc.
exact a.
apply ab.
exact a.
Show Proof.
Qed.

Lemma q2 (A B : Prop) :  A -> (B -> A).
Proof.
intros a b.
exact a.
Show Proof.
Qed.

Lemma q3 (A B : Prop) :  A -> (~A -> B).
Proof.
intros a na.
destruct na.
exact a.
Show Proof.
Qed.

Lemma q4 (A B C : Prop) :  (A -> B) -> ((B -> C) -> (A -> C)).
Proof.
intros ab bc a.
apply bc.
apply ab.
exact a.
Show Proof.
Qed.

Lemma q5 (A B : Prop) :  (A -> B) -> (~B -> ~A).
Proof.
intros ab nb.
intro na.
destruct nb.
apply ab.
exact na.
Show Proof.
Qed.

Require Import Classical.

Lemma bottom_c (A : Prop) : (~A -> False) -> A.
Proof.
intro na.
apply NNPP.
intros nna.
apply na.
exact nna.
Qed.


Lemma tiersexclus (A : Prop) : A \/ ~A.
Proof.
apply bottom_c.
intro naa.
apply naa.
left.
apply NNPP.
intro nna.
apply naa.
right.
exact nna.
Show Proof.
Qed.


Lemma q8 (A B : Prop) : (~B -> ~A) -> (A -> B).
Proof.
intros nbna a.
apply NNPP.
intro nnb.
apply nbna.
exact nnb.
exact a.
Show Proof.
Qed.

Lemma q9 (A : Prop) : ~~A <-> A.
Proof.
split.
intro nna.
apply NNPP.
exact nna.
intro a.
intro nna'.
apply nna'.
exact a.
Qed.

Lemma q10 (A : Prop) :  (A /\ ~A) <-> False.
Proof.
split.
intro ana.
destruct ana.
apply H0.
exact H.
intro f.
split.
destruct f.
destruct f.
Show Proof.
Qed.

Lemma q11 (A B : Prop) :  (A \/ B) <-> ~(~A /\ ~B).
Proof.
split.
intro ab.
intro nnanb.
destruct nnanb.
destruct H.
destruct ab.
exact H.
destruct H0.
exact H.
intro nnanb.
apply bottom_c.
intro nab.
apply nnanb.
split.
intro na.
apply nab.
left.
exact na.
intro na.
apply nab.
right.
exact na.

Qed.

Lemma q12 (A : Prop) :  ~A <-> (A -> False).
Proof.
split.
intros na a.
destruct na.
exact a.
intros af a.
apply af.
exact a.
Qed.

Lemma q13 (A B : Prop) :  (A <-> B) <-> (A -> B) /\ (B -> A).
Proof.
split.
intro aeb.
split.
intro a.
apply aeb.
exact a.
apply aeb.
intro abeba.
split.
apply abeba.
apply abeba.
Qed.

Lemma q14 (A B C : Prop) :  (A /\ B -> C) <-> (A -> B -> C).
Proof.
split.
intros abc a b.
apply abc.
split.
exact a.
exact b.
intro abc.
intro ab.
apply abc.
apply ab.
apply ab.
Qed.

Lemma q15 (A B C : Prop) :  (C -> A)\/ (C -> B) <-> (C -> A \/ B).
Proof.
Qed.

Lemma q16 (X : Type) (A B : X -> Prop) : ((forall x, A x) \/ (forall x, B x)) -> forall x, A x \/ B x.
Proof.
Qed.

Lemma q17 (X : Type) (A B : X -> Prop) : (exists x, A x /\ B x) -> ((exists x, A x) /\ (exists x, B x)).
Proof.
Qed.

Lemma q18 (A B : Prop) : ~ (A /\ B) -> (~ A \/ ~ B).
Proof.
Qed.

Lemma q19 (X : Type) : forall (x1 x2 : X), x1 = x2 -> x2 = x1.
Proof.
Qed.

Lemma q20 (X : Type) : forall (x1 x2 x3 : X), x1 = x2 /\ x2 = x3 -> x1 = x3.
Proof.
Qed.

