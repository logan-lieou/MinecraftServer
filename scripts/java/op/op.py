#!/usr/bin/python

def main():

 
    """ Generate modops string to write to file """

    opsf = open("../../../src/ops.json", "r+")
    op_string = opsf.read()
    size_of_ops = len(op_string)

    # check if there are ops
    if (size_of_ops > 2):
        # if there are already ops
        modops = op_string[0:size_of_ops - 4] + ", { \"uuid\": \"2f563a91-9ea0-445f-a1af-14ac67d88538\", \"name\": \"eeayor\", \"level\": 4, \"bypassesPlayerLimit\": true }; ]"
    else:
        # if there are no ops
        modops = "[ { \"uuid\": \"2f563a91-9ea0-445f-a1af-14ac67d88538\", \"name\": \"eeayor\", \"level\": 4, \"bypassesPlayerLimit\": true }; ] "

    # close io stream
    opsf.close()
 

    """ Write the changes to the file """

    opsf = open("../../../src/ops.json", "w+")
    opsf.write(modops)

    # close io stream
    opsf.close()


if __name__ == "__main__":

    # run main
    main()
