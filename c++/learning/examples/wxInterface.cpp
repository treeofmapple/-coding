#include <wx/wx.h>

class MyFrame : public wxFrame {
private:
    int count;
    wxStaticText* label;

public:
    MyFrame() : wxFrame(nullptr, wxID_ANY, "wxWidgets Counter", wxDefaultPosition, wxSize(300, 200)), count(0) {
        wxPanel* panel = new wxPanel(this);
        wxBoxSizer* sizer = new wxBoxSizer(wxVERTICAL);

        label = new wxStaticText(panel, wxID_ANY, "Clicks: 0", wxPoint(120, 50));
        wxButton* button = new wxButton(panel, wxID_ANY, "Click Me", wxPoint(100, 100), wxSize(100, 30));

        sizer->Add(label, 0, wxALIGN_CENTER | wxTOP, 20);
        sizer->Add(button, 0, wxALIGN_CENTER | wxTOP, 10);

        panel->SetSizer(sizer);

        button->Bind(wxEVT_BUTTON, &MyFrame::OnButtonClick, this);
    }

    void OnButtonClick(wxCommandEvent& event) {
        count++;
        label->SetLabel(wxString::Format("Clicks: %d", count));
    }
};

class MyApp : public wxApp {
public:
    virtual bool OnInit() {
        MyFrame* frame = new MyFrame();
        frame->Show();
        return true;
    }
};

wxIMPLEMENT_APP(MyApp);
