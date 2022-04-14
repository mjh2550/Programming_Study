# Report Book summary - 아키텍처를 알아야 앱 개발이 보인다.

* 객체지향 5원칙
SRP,OCP,LSP,ISP,DIP

* 안드로이드 MVC : Model + View + Controller

    - 모델
    비즈니스 데이터
    POJO,SQLite,Room,Realm

    - 뷰
    화면
    Activity,Fragment

    - 컨트롤러
    모델과 뷰에 의존, 뷰로부터 입력을 받거나 이벤트 발생시 모델과 뷰를 변경할 수 있다.
    Activity,Fragment

    - 장점
    구조 단순하고 직관적, 규모가 작은 작업에 적합

    - 단점
    코드량 증가 로 인한 스파게티 되기 쉬움, 유지보수비용 증가, 컨트롤러가 뷰와 모델에 의존적이여서 결합도가 높고, 유닛테스트 거의 불가능

* 안드로이드 MVP : Model + View + Presenter
    MVC와 비슷하나 View와 비즈니스 로직 분리하는데에 집중

    - Presenter
    Presenter는 View와 Model의 인스턴스를 가지며 둘을 연결해주는 역할을 하며 1:1관계이다.

    - 장점
    view와 model 간 의존성 없음,유닛테스트 수월

    - 단점
    view와 presenter간 의존성 높음, presenter 재사용 불가
    MVC와 마찬가지로 규모가 커질수록 유지보수가 어려워짐

* 안드로이드 MVVM : Model + View + ViewModel
    ViewModel 이 View와 관계없이 Model과 계속 상호작용하고, Data가 변화할 때 마다 LiveData를 가져오며 View는 ViewModel을 보고 View를 계속 갱신함

* Dagger2는 자바&안드로이드를 위한 강력하고 빠른 의존성 주입 프레임워크이다. 리플렉션을 사용하지 않고, 런타임시 바이트코드를 생성하지 않는 것이 특징이다.
컴파일 타임에 어노테이션에 의해 의존성주입과 관련된 모든 코드를 분석하고 자바 소스코드를 생성한다.

* 리플렉션은 권한자 상관없이 클래스, 생성자, 메서드, 필드에 접근할 수 있는 자바 기능이다. 대안으로는 인터페이스 호출, 객체 생성, 하드코딩이 있다.

* Dagger2 : 의존성 주입 라이브러리 (쓰게될 시 자세히 알아볼 예정이므로 생략함, 비슷한 라이브러리 로는 Koin, Hilt 
등이있다)

* 안드로이드 VM
 Dalvik vs ART : https://brunch.co.kr/@mystoryg/81
 

* ReactiveX : 옵저버 패턴, 이터레이터 패턴, 함수형 프로그래밍의 장점과 개념을 접목한 프로그래밍 기법.


* RxJava : ReactiveX를 자바로 구현한 라이브러리.이벤트 처리 및 비동기 처리의 구성에 최적화된 라이브러리이다.
  

