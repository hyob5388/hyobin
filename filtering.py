fword_list = []

def print_help():
    print(
        '',
        '---------------',
        '욕설방지 프로그램',
        '0: 종료',
        '1:금지 단어 입력',
        '2:금지 단어 확인',
        '3:금지 단어 삭제',
        '4:채팅치기',
        '---------------',
        '',
        sep='\n'
        )
while True:
    print_help()
    choice = input ('실행하고자 하는 번호를 입력>>')
    if choice =='0':
        print('프로그램을 종료합니다')
        break
    elif choice == '1':
        fword = input ('입력할 단어를 입력해주세요>>')
        i=len(fword)
        if fword not in fword_list:
            fword_list.append(fword)
            
    elif choice =='2':
        print('금지단어 목록입니다')
        print('\n'.join(fword_list))

    elif choice == '3':
        cuss = input ('삭제할 단어를 입력해주세요>>')
        if fword not in fword_list:
            print('잘못 입력했습니다')

        else:
            fword_list.remove(fword)
    elif choice == '4':
        id = input('아이디>>')
        test_string = input('채팅>>')
        replaced_string = test_string
        for fword in fword_list:
            replaced_string = replaced_string.replace(fword,i*'*')
   
        print('-----------------')
        print(id + ':' + replaced_string)

    else:
        print('잘못입력함')


