//
//  TableViewController.swift
//  TestTableView
//
//  Created by Moon Jihong on 2023/09/16.
//

import UIKit

class TableViewController: UIViewController {
    
    @IBOutlet weak var mainTv: UITableView!
    
    var tableList = ["test1","test2","test3"]

    override func viewDidLoad() {
        super.viewDidLoad()
        
        mainTv.delegate = self
        mainTv.dataSource = self
        
    }

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
extension TableViewController: UITableViewDataSource, UITableViewDelegate {
    // MARK: - Table view data source
    
    func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return tableList.count
    }

    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)

        // Configure the cell...
        cell.textLabel?.text = tableList[indexPath.row]

        return cell
    }

}

extension TableViewController: UIPopoverPresentationControllerDelegate {
    //MARK: present popOverVC
    
    func tableView(_ tableView: UITableView, accessoryButtonTappedForRowWith indexPath: IndexPath) {
        // 팝오버 뷰 컨트롤러 생성
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let popoverVC = storyboard.instantiateViewController(withIdentifier: "PopOverViewController") as! PopOverViewController
        
        let screenWidth = UIScreen.main.bounds.width
        popoverVC.preferredContentSize = CGSize(width: screenWidth, height: 200)
               
        // 팝오버 프레젠테이션 스타일 설정
        popoverVC.modalPresentationStyle = .popover
        
        // 팝오버 컨트롤러 생성
        let popoverController = popoverVC.popoverPresentationController
        popoverController?.delegate = self
        popoverController?.sourceView = tableView.cellForRow(at: indexPath)
        popoverController?.sourceRect = tableView.cellForRow(at: indexPath)?.bounds ?? CGRect.zero

        // 팝오버 배경을 완전히 투명하게 설정
//        popoverController?.backgroundColor = UIColor(white: 1.0, alpha: 0.0)
        
        // 팝오버 표시
        present(popoverVC, animated: true, completion: nil)
    }
    
    //MARK: 뷰가 회전할 때 팝오버 설정
    func presentationController(_ controller: UIPresentationController, viewControllerForAdaptivePresentationStyle style: UIModalPresentationStyle) -> UIViewController? {
        // 팝오버 뷰 컨트롤러 호출
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let popoverVC = storyboard.instantiateViewController(withIdentifier: "PopOverViewController") as! PopOverViewController
        
        let screenWidth = UIScreen.main.bounds.width
        popoverVC.preferredContentSize = CGSize(width: screenWidth, height: 200)

        // 팝오버 프레젠테이션 스타일 설정
        popoverVC.modalPresentationStyle = .popover

        return popoverVC
    }
    
    //MARK: 커스텀 모달 창 구현
    func adaptivePresentationStyle(for controller: UIPresentationController) -> UIModalPresentationStyle {
        return .popover
    }

    
    // 커스텀 팝오버 모달의 크기를 조정
//    func popoverPresentationController(_ popoverPresentationController: UIPopoverPresentationController, willRepositionPopoverTo rect: UnsafeMutablePointer<CGRect>, in view: AutoreleasingUnsafeMutablePointer<UIView>) {
//        // 팝오버 모달의 크기와 위치를 조정합니다.
//        // rect과 view에 원하는 크기와 위치를 설정해주세요.
//        // 여기에 말풍선이 없는 커스텀 팝오버 모달의 크기와 위치를 지정하세요.
//    }
    
    func prepareForPopoverPresentation(_ popoverPresentationController: UIPopoverPresentationController) {
        // 커스텀 배경 뷰를 팝오버에 설정합니다.
//        popoverPresentationController.popoverBackgroundViewClass = PopOverViewController.self
    }
}

