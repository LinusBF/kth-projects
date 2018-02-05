copy:
    lw $t0, 0($a0)  # Load word at source address
    sw $t0, 0($a1)  # Store loaded word at destination address
    add $v0, $0, $a1  # Set return value to destination address
    jr $ra