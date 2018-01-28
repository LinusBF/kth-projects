.data
.align 2
msg: .space 8
.text
main: la $t1, msg
    la $t2, 0x27AC722B
    sw $t2,0($t1)
    add $a0, $0, $t1
    la $a1, 4($t1)
    addi $a2, $0, 4
    jal copy

    j stop
copy:
    la $t0, 0($a0)  # Load source address
    la $t1, 0($a1)  # Load destination address
    addi $t2, $0, 0  # Set i in for loop comparison to data size

    loop:
        slt $t3, $t2, $a2  # if (t2 < a2)
        beq $t3, $0, done  #     jump to done
                           # else
        add $t4, $t0, $t2  # Set offset for source
        add $t5, $t1, $t2  # Set offset for destination
        lb $t6, 0($t4)  # Load byte from source
        sb $t6, 0($t5)  # Set stored byte at destination
        addi $t2, $t2, 1  # i++
        j loop
    done:
        add $v0, $0, $t1  # Set return value to destination address
        jr $ra

stop: j stop