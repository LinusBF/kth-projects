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
	li	$a0,1000
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
	addi $t0, $0, 1	# Initialize constant
	add $t1, $0, $0		# Initialize i
	while:
		add $t1, $0, $0		# Reset i
		for:
			addi $t1, $t1, 1	# i + 1
			bne $t1, $t0, for	# i < const
			nop

		subi $a0, $a0, 1	# ms - 1
		slti $t2, $a0, 1	# if(ms > 0)
		bne $t2, 1, while	#   continue while
		nop
	
	jr $ra
	nop
 
time2string:
	PUSH($s0)
	PUSH($s1)
	PUSH($s2)
	andi $s0, $a1, 0xffff	# Mask a1 so that only the 4 LSB are left
	li $s1, 0		# Init value to store clock in ascii
	li $s2, 0		# Init i for loop
	PUSH($ra)		
	loop:
		slti $t3, $s2, 4	# Check i >= 4
		beq $t3, $0, done
		nop
 		add $t4, $0, $s2	# Set t4 to i
 		sll $t4, $t4, 2		# Multiply i by 4 for byte index
 		srlv $t5, $s0, $t4	# Shift a1 so that the the byte at i is visible
 		
 		PUSH($a0)		# Put given a0 and a1 on the stack
 		PUSH($a1)
 		add $a0, $t5, $0	# Set argument for hexasc function
 		jal hexasc		# Call hexasc
 		nop
 		
 		POP($a1)
 		POP($a0)
 		sll $s1, $s1, 8		# Shift ascii clock value 8 bits to the left to make room for return value from hexasc
 		or $s1, $s1, $v0	# Or answer from hexasc into ascii clock value variable
 		addi $s2, $s2, 1	# Increment i

		j loop
		nop
 	done:
 		POP($ra)
 		
 		andi $t3, $s1, 0xffff		# Mask ascii clock value with FFFF to store minutes in the LSB
 		ori $t3, $t3, 0x3A0000		# Or in the ascii value for comma
 		andi $t4, $s1, 0xff0000		# Mask ascii clock value with FF00 to get most significant seconds number
 		sll $t4, $t4, 8			# Shift the value to the left to fit in $t3
 		or $t3, $t3, $t4		# Or in the most significant seconds number in the LSB of t3
 		
 		la $t6, 0xff000000
 		andi $t5, $s1,$t6 		# Mask scii clock value with FF000000 to store least significant seconds number
 		srl $t5, $t5, 24		# Shift to LSB
 		
 		andi $t6, $s0, 0x1
 		addi $t7, $0, 0x44
 		bne $t6, $0, odd
 		nop
 		addi $t7, $t7, 1

 		odd:
 		sll $t7, $t7, 8
 		or $t5, $t5, $t7
 		
 		sw $t3, 0($a0)			# Store t3 (first 4 ascii characters) at the address in a0
 		sw $t5, 4($a0)			# Store t5 (last ascii character) at the word after a0 (a0 + 4)
 		
 		POP($s2)
 		POP($s1)
 		POP($s0)
 		
 		jr $ra
 		nop
 
