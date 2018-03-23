Inductive entier : Type :=
  | O : entier
  | S : entier -> entier.

Fixpoint plus (n m : entier) : entier :=
  match n with
    | O => m
    | S n' => S (plus n' m)
  end.

Theorem associativite (n m p : entier) : plus n (plus m p) = plus (plus n m) p.
Proof.
induction n.
-reflexivity.
-simpl.
 rewrite IHn.
 reflexivity.
Qed.

Lemma plus0 (n : entier) : plus n O = n.
Proof.
induction n.
- simpl.
  reflexivity.
- simpl.
  rewrite IHn.
  reflexivity.
Qed.

Lemma plusS (n p : entier) : plus n (S p) = S (plus n p).
Proof.
induction n.
 - simpl.
   reflexivity.
 - simpl.
   rewrite IHn.
   reflexivity.
Qed.

Theorem symetrie (n m : entier) : plus n m = plus m n.
Proof.
induction n.
 - simpl.
   rewrite plus0.
   reflexivity.
 - rewrite plusS.
   simpl.
   rewrite IHn.
   reflexivity.    
Qed.

Lemma egalS (n m : entier) : n = m <-> S n = S m.
Proof.
split.
 - intro a.
   rewrite a .
   reflexivity.
 - intro a.
   injection a.
   intro b.
   apply b.
Qed.

Theorem simplification (a n m : entier) : plus a n = plus a m <-> n = m.
Proof.
split.
 - induction a; simpl; intros; trivial.
   apply IHa.
   apply egalS.
   exact H.
 - intro Eq; rewrite Eq; reflexivity.
Qed.


Fixpoint mult (n m : entier) : entier := 
  match n with 
  | O => O 
  | S n' => plus m (mult n' m) 
  end.

Lemma multO (n : entier) : mult n O = O.
Proof.
induction n.
- simpl.
  reflexivity.
- simpl.
  rewrite IHn.
  reflexivity.
Qed.

Lemma assoc2 (n m p : entier) : plus n (plus m p) = plus m (plus n p).
Proof.
induction n.
-simpl.
 reflexivity.
-simpl.
 rewrite IHn.
 rewrite plusS.
 reflexivity.
Qed.

Lemma multsn (n m : entier) : mult n (S m) = plus n (mult n m).
Proof.
induction n.
 - simpl.
   reflexivity.
 - simpl.
   rewrite IHn.
   rewrite assoc2.
   reflexivity.
Qed.

Theorem symetriemult (n m : entier) : mult n m = mult m n.
Proof.
induction n.
 -simpl.
  rewrite multO.
  reflexivity.
 -rewrite multsn.
  simpl.
  rewrite IHn.
  reflexivity.
Qed.

Theorem distributivite (n m p : entier) : mult (plus n m) p = plus (mult n p) (mult m p).
Proof.
induction n.
- simpl.
  reflexivity.
- simpl.
  symmetry.
  rewrite IHn.
  rewrite associativite.
  reflexivity.
Qed.

Theorem associativitemult (n m p : entier) : mult n (mult m p) = mult (mult n m) p.
Proof.
induction n.
-simpl.
 reflexivity.
-simpl.
 rewrite IHn.
 symmetry.
 rewrite distributivite.
 reflexivity.
Qed.
