  # timetemplate.asm
  # Written 2015 by F Lundevall
  # Copyright abandonded - this file is in the public domain.

.macro	PUSH (%reg)
	addi	$sp,$sp,-4
	sw	%reg,0($sp)
.end_macro

.macro	POP (%reg)
	lw	%reg,0($sp)
	addi	$sp,$sp,4
.end_macro

	.data
	.align 2
mytime:	.word 0x5957
timstr:	.ascii "text more text lots of text\0"
	.text
main:
	# print timstr
	la	$a0,timstr
	li	$v0,4
	syscall
	nop
	# wait a little
	li	$a0,2
	jal	delay
	nop
	# call tick
	la	$a0,mytime
	jal	tick
	nop
	# call your function time2string
	la	$a0,timstr
	la	$t0,mytime
	lw	$a1,0($t0)
	jal	time2string
	nop
	# print a newline
	li	$a0,10
	li	$v0,11
	syscall
	nop
	# go back and do it all again
	j	main
	nop
# tick: update time pointed to by $a0
tick:	lw	$t0,0($a0)	# get time
	addiu	$t0,$t0,1	# increase
	andi	$t1,$t0,0xf	# check lowest digit
	sltiu	$t2,$t1,0xa	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x6	# adjust lowest digit
	andi	$t1,$t0,0xf0	# check next digit
	sltiu	$t2,$t1,0x60	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa0	# adjust digit
	andi	$t1,$t0,0xf00	# check minute digit
	sltiu	$t2,$t1,0xa00	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x600	# adjust digit
	andi	$t1,$t0,0xf000	# check last digit
	sltiu	$t2,$t1,0x6000	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa000	# adjust last digit
tiend:	sw	$t0,0($a0)	# save updated result
	jr	$ra		# return
	nop

  # you can write your code for subroutine "hexasc" below this line
  #

hexasc:
	andi $t0, $a0, 0xf	# Mask a0 so that only the 4 lsb are left
	slti $t1, $t0, 10
	beq $t1, $0, letter	# If a0 >= 10 handle like letter
	nop			# Else handle like number
	addi $t2, $t0, 0x30	# Add 0x30 to a0 to convert it to the ascii code for a0
	j end			# Skip letter handling
	nop			# Safety
	letter:
	addi $t0, $t0, -10	# Reduce t0 to account for the offset of 10 in the number for letter conversion
	addi $t2, $t0, 0x41	# Add 0x41 to a0 to convert it to the ascii code for the letter a0 represents

	end:
	add $v0, $t2, $0	# Set v0 to the new converted number
	jr $ra			# Return to function call
	nop			# Safety
	
delay:
 jr $ra
 nop
 
time2string:
	andi $t0, $a1, 0xffff	# Mask a1 so that only the 4 LSB are left
	li $t1, 0		# Init value to store answer
	li $t2, 0		# Init i for loop
	PUSH($a0)
	PUSH($a1)
	PUSH($t0)
	PUSH($t1)
	PUSH($t2)
	loop:
		slti $t3, $t2, 4	# Check i >= 4
		beq $t3, $0, done
		addi $t4, $0, 3
 		sub $t4, $t4, $t2	# Set t4 to 4 - i
 		sll $t4, $t4, 2
 		srlv $t5, $t0, $t4	# Shift a1 so that the the byte at i is visible
 		add $a0, $t5, $0	# Set argument for hexasc function
 		jal hexasc		# Call hexasc
 		nop
 		POP($t2)		# Load variabels after function call
 		POP($t1)
 		POP($t0)
 		POP($a1)
 		POP($a0)
 		sll $t1, $t1, 8
 		or $t1, $t1, $v0
 		addi $t2, $t2, 1
 		PUSH($a0)	# PUSH variabels for safe keeping during next loop
		PUSH($a1)
		PUSH($t0)
		PUSH($t1)
		PUSH($t2)
		j loop
		nop
 	done:
 		POP($t2)	# Load variabels after function call
 		POP($t1)
 		POP($t0)
 		POP($a1)
 		POP($a0)
 		
 		andi $t3, $t1, 0xffff0000
 		ori $t3, $t3, 0x3A00
 		andi $t4, $t1, 0xff00
 		srl $t4, $t4, 8
 		or $t3, $t3, $t4
 		
 		andi $t5, $t1, 0xff
 		sll $t5, $t5, 24
 		
 		sw $t3, 0($a0)
 		sw $t5, 4($a0)
 
 		jr $ra
 
 
