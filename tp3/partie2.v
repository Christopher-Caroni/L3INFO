Definition faux := forall (P : Prop), P.
Definition non (A : Prop) := forall (P : Prop), ((A -> faux) -> P) -> P.
Definition et (A B : Prop) := forall (P : Prop), (A -> B -> P) -> P.
Definition ou (A B : Prop) := forall (P : Prop), ((A -> P) -> (B -> P) -> P).
Definition existe (A : Type) (P : A -> Prop) := forall (Q : Prop), (forall a, P a -> Q) -> Q.
Definition egal (A : Type) (a a' : A) := forall (P : A -> Prop), P a -> P a'.

Lemma bottom_e (A : Prop) : faux -> A.
Proof.
Qed.

Lemma non_intro (A : Prop) : (A -> faux) -> non A.
Proof.
Qed.

Lemma non_elim (A : Prop) : A -> non A -> faux.
Proof.
Qed.

Lemma et_intro (A B : Prop) : A -> B -> et A B.
Proof.
Qed.

Lemma et_elim_g (A B : Prop) : et A B -> A.
Proof.
Qed.

Lemma et_elim_d (A B : Prop) : et A B -> B.
Proof.
Qed.

Lemma ou_intro_g (A B : Prop) : A -> ou A B.
Proof.
Qed.

Lemma ou_intro_d (A B : Prop) : B -> ou A B.
Proof.
Qed.

Lemma ou_elim (A B C : Prop) : ou A B -> (A -> C) -> (B -> C) -> C.
Proof.
Qed.

Lemma existe_intro (A : Type) (P : A -> Prop) : forall x : A, P x -> existe A P.
Proof.
Qed.

Lemma existe_elim (A : Type) (P : A -> Prop) (Q : Prop) : existe A P -> (forall x : A, P x -> Q) -> Q.
Proof.
Qed.

Lemma faux_false : faux <-> False.
Proof.
Qed.

Lemma non_not (A : Prop) : non A <-> ~A.
Proof.
Qed.

Lemma et_and (A B : Prop) : et A B <-> A /\ B.
Proof.
Qed.

Lemma ou_or (A B : Prop) : ou A B <-> A \/ B.
Proof.
Qed.

Lemma existe_exists (A : Type) (P : A -> Prop) : existe A P <-> exists a, P a.
Proof.
Qed.

Lemma egal_eq (A : Type) (a a' : A) : egal _ a a' <-> a = a'.
Proof.
Qed.
